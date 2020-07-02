package com.lt.edu.service.impl;

import com.lt.utils.CommonEntity.Video;
import com.lt.edu.mapper.VideoMapper;
import com.lt.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
