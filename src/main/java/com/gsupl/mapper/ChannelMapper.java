package com.gsupl.mapper;

import com.gsupl.entity.Channel;

import java.util.List;

public interface ChannelMapper {

	int create(Channel channel);

	int delete(Integer id);

	int update(Channel channel);

	List<Channel> query(Channel channel);

	Channel detail(Integer id);

	int count(Channel channel);
}
