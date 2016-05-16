package junit;

import elec.domain.ElecText;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.hibernate.cfg.Configuration;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
public class TestHibernate {
    @Test
    public void testElecText(){
        Configuration config = new Configuration();
        config.configure();
        //创建seesionFactory
        SessionFactory sf = config.buildSessionFactory();
        //打开session
        Session session = sf.openSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        //实例化对象，执行保存
        ElecText elecText = new ElecText();
        elecText.setTextName("Test");
        elecText.setTextDate(new Date());
        elecText.setTextRemark("test remark!");
        session.save(elecText);
        //提交
        tr.commit();
        session.close();
    }
}

