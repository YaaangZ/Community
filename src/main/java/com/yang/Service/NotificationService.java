package com.yang.Service;

import com.yang.Dto.NotificationDto;
import com.yang.Dto.PageDto;
import com.yang.Dto.QuestionDto;
import com.yang.Enums.NotificationStatusEnum;
import com.yang.Enums.NotificationTypeEnum;
import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import com.yang.Model.*;
import com.yang.mapper.NotificationMapper;
import com.yang.mapper.QuestionMapper;
import com.yang.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PageDto list(Long userId, Integer page, Integer size) {
        PageDto<NotificationDto> pageDtos = new PageDto<>();
        Integer totalPage;
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(userId);
        Integer totalCount = (int) notificationMapper.countByExample(notificationExample);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        pageDtos.setPagination(totalPage, page);

        Integer offset = (size * (page - 1));
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(notificationExample, new RowBounds(offset, size));
        if (notifications.size() == 0) {
            return pageDtos;
        }

        List<NotificationDto> notificationDtoList = new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDto notificationDto = new NotificationDto();
            BeanUtils.copyProperties(notification, notificationDto);
            notificationDto.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDtoList.add(notificationDto);
        }


        pageDtos.setData(notificationDtoList);

        return pageDtos;
    }

    public Long unreadCount(Long userId) {
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(userId)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(example);
    }

    public NotificationDto read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if (notification == null) {
            throw new exception(errCode.NOTIFICATION_NOT_FOUND);
        }
        if (!Objects.equals(notification.getReceiver(), user.getId())) {
            throw new exception(errCode.READ_NOTIFICATION_FAIL);
        }

        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDto notificationDto = new NotificationDto();
        BeanUtils.copyProperties(notification, notificationDto);
        notificationDto.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDto;
    }
}
