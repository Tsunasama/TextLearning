
package com.tsuna.textLearning.persistance.service;

import com.tsuna.textLearning.persistance.FactoryManager;
import com.tsuna.textLearning.persistance.bean.Topic;
import com.tsuna.textLearning.persistance.mapper.TopicMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TopicService {

    private static final Logger LOGGER = Logger.getLogger(TopicService.class);

    private SqlSessionFactory factory;

    {
        try {
            factory = FactoryManager.getFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Topic getTopic(int id) {
        Topic topic = null;
        try (SqlSession sqlSession = factory.openSession()) {
            TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
            topic = mapper.getTopic(id);
            sqlSession.commit();
        } catch (Exception ex) {
            TopicService.LOGGER.error(ex);
        }
        return topic;
    }

    public void insertTopic(Topic topic) {
        try (SqlSession sqlSession = factory.openSession()) {
            TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
            mapper.insertTopic(topic);
            sqlSession.commit();
        } catch (Exception ex) {
            TopicService.LOGGER.error(ex);
        }
    }
}
