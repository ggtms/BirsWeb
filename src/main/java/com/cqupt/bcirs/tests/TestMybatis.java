package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.dao.CardDao;
import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.service.Status;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 16:17
 */
public class TestMybatis {

    /**
     *测试可以添加数据进数据库
     */
    @Test
    public void run1() throws IOException {
        Card card =new Card();
        card.setNumber(0);
        card.setIssuer("中国什么银行");
        card.setAccount("1010101010101010101");
        card.setDate("2012-03-14");
        card.setStatu(Status.VALID);
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        CardDao dao = session.getMapper(CardDao.class);

        // 保存
        dao.saveBankCard(card);

        // 提交事务         没事务管理就需手动提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试可以从数据库中拿出数据
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        CardDao dao = session.getMapper(CardDao.class);

        List<Card> list = dao.findAllList();
        for (Card card: list ) {
            System.out.println(card);
        }

        session.close();
        in.close();
    }

    @Test
    public void run3() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        CardDao dao = session.getMapper(CardDao.class);
        dao.deleteBankCard();
        System.out.println("删除成功");
        // 提交事务         没事务管理就需手动提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

}
