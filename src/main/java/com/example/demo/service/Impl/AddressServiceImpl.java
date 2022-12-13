package com.example.demo.service.Impl;

import com.example.demo.api.param.AddAddressParam;
import com.example.demo.api.vo.AddressVo;
import com.example.demo.dao.AddressMapper;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public List<AddressVo> show(String userid) {
        return addressMapper.show(userid);
    }

    @Override
    public void setMoren(String adid) {
        addressMapper.setMoren(adid);
    }

    @Override
    public void setMorenAll(String userid) {
        addressMapper.setMorenAll(userid);
    }

    @Override
    public List<AddressVo> showById(String adid, String userid) {
        return addressMapper.showById(adid,userid);
    }

    @Override
    public void add(AddAddressParam addAddressParam) {
        addressMapper.add(addAddressParam);
    }

    @Override
    public void del(String adid) {
        addressMapper.del(adid);
    }


}
