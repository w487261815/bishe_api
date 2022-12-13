package com.example.demo.service;

import com.example.demo.api.param.AddAddressParam;
import com.example.demo.api.vo.AddressVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {
    List<AddressVo> show(@Param("userid") String userid);
    void setMoren(@Param("adid") String adid);
    void setMorenAll(@Param("userid") String userid);
    List<AddressVo> showById(@Param("adid") String adid,@Param("userid") String userid);
    void add(@Param("addAddressParam") AddAddressParam addAddressParam);
    void del(@Param("adid") String adid);
}
