package com.example.demo.config.handler;
import com.example.demo.common.AnimalException;
import com.example.demo.common.ServiceResultEnum;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.AnnimalTokenImpl;
import com.example.demo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

@Component
public class TokenToAdminUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Resource
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AnnimalTokenImpl annimalToken;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("进入拦截器中1");
        if (parameter.hasParameterAnnotation(TokenToAdminUser.class)) {
            return true;
        }
        return false;
    }
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToAdminUser.class) instanceof TokenToAdminUser) {
            String gouyanToken=webRequest.getHeader("Authorization");
            System.out.println(gouyanToken);
            if(StringUtils.isEmpty(gouyanToken)){
                AnimalException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
            }
            if(!gouyanToken.startsWith("Annimal")){
                AnimalException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
            }
            String tokens[] = gouyanToken.split(" ");
            if(tokens.length!=2){
                AnimalException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
            }
            String token=tokens[1];
            Object user=redisTemplate.opsForValue().get(token);
            if(user==null){
                AnimalException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
            }
            System.out.println(tokens[1]);
            String uid=annimalToken.getUsername(tokens[1]);
            UserInfoEntity userInfoEntity=userService.getInfo(uid).get(0);
            userInfoEntity.setToken(tokens[1]);
            return userInfoEntity;
            //放行
        }
        return null;
    }
}
