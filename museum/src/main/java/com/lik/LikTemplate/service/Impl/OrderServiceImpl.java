package com.lik.LikTemplate.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lik.LikTemplate.entity.Order;
import com.lik.LikTemplate.mapper.OrderMapper;
import com.lik.LikTemplate.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
