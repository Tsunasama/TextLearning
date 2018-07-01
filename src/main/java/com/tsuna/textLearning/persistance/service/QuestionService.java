
package com.tsuna.textLearning.persistance.service;

import com.tsuna.textLearning.persistance.FactoryManager;
import com.tsuna.textLearning.persistance.bean.Question;
import com.tsuna.textLearning.persistance.mapper.QuestionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class QuestionService {
    private static final Logger LOGGER = Logger.getLogger(QuestionService.class);

    private SqlSessionFactory factory;

    {
        try {
            factory = FactoryManager.getFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question getQuestion(int id) {
        Question question = null;
        try (SqlSession sqlSession = factory.openSession()) {
            QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
            question = mapper.getQuestion(id);
            sqlSession.commit();
        } catch (Exception ex) {
            QuestionService.LOGGER.error(ex);
        }
        return question;
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = null;
        try (SqlSession sqlSession = factory.openSession()) {
            QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
            questionList = mapper.getAllQuestions();
            sqlSession.commit();
        } catch (Exception ex) {
            QuestionService.LOGGER.error(ex);
        }
        return questionList;
    }

    public void insertQuestion(Question question) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            QuestionMapper mapper = session.getMapper(QuestionMapper.class);
            mapper.insertQuestion(question);
            session.commit();
        } catch (Exception ex) {
            QuestionService.LOGGER.error(ex);
        } finally {
            session.commit();
        }
    }

    public void updateQuestion(Question question) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            QuestionMapper mapper = session.getMapper(QuestionMapper.class);
            mapper.updateQuestion(question);
            session.commit();
        } catch (Exception ex) {
            QuestionService.LOGGER.error(ex);
        } finally {
            session.commit();
        }
    }

    public int deleteQuestion(int id) {
        SqlSession session = null;
        int count = 0;
        try {
            session = factory.openSession();
            QuestionMapper mapper = session.getMapper(QuestionMapper.class);
            count = mapper.deleteQuestion(id);
            session.commit();
        } catch (Exception ex) {
            QuestionService.LOGGER.error(ex);
        } finally {
            session.commit();
        }
        return count;
    }
}
