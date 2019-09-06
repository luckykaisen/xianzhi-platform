package com.xianzhi.platform;

import com.xianzhi.platform.webapp.common.model.PagingData;
import com.xianzhi.platform.webapp.data.dao.GoodsDao;
import com.xianzhi.platform.webapp.data.filter.GoodsCommentFilter;
import com.xianzhi.platform.webapp.model.GoodsComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class XianzhiPlatformApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void contextLoads() {

        GoodsCommentFilter filter = new GoodsCommentFilter();
        filter.setGoodsId(1);

        List<GoodsComment> comments = goodsDao.selectGoodsCommentByFilter(filter);

        System.out.println(comments);
    }

}
