package com.fwtai.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * dao底层操作处理工具类
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018-12-09 18:56
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
 */
@Repository
public class DaoBase{

    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    /**
     * 用于查询返回Integer
     * @作者 田应平
     * @返回值类型 Integer
     * @创建时间 2016年12月24日 23:00:55
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public Integer queryForInteger(final String sqlMapId) throws Exception {
        return sqlSession.selectOne(sqlMapId);
    }

    /**
     * 用于查询返回Integer
     * @作者 田应平
     * @返回值类型 Integer
     * @创建时间 2016年12月24日 23:01:35
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public Integer queryForInteger(final String sqlMapId, final Object objParam) throws Exception {
        return sqlSession.selectOne(sqlMapId,objParam);
    }

    /**
     * 用于查询返回String
     * @作者 田应平
     * @返回值类型 String
     * @创建时间 2016年11月20日 下午2:24:52
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public String queryForString(final String sqlMapId) throws Exception {
        return sqlSession.selectOne(sqlMapId);
    }

    /**
     * 用于查询返回String
     * @作者 田应平
     * @返回值类型 String
     * @创建时间 2016年12月25日 00:44:39
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public String queryForString(final String sqlMapId, final Object objParam) throws Exception {
        return sqlSession.selectOne(sqlMapId,objParam);
    }

    /**
     * 根据id去查询,或必须保证sql所查询的结果只有一条或限制返回一条数据
     * @作者 田应平
     * @返回值类型 Map<String,Object>
     * @创建时间 2016年12月24日 23:03:07
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public Map<String, Object> queryForMap(final String sqlMapId) throws Exception {
        return sqlSession.selectOne(sqlMapId);
    }

    /**
     * 必须保存sql所查询的结果只有一条或限制返回一条数据
     * @作者 田应平
     * @返回值类型 Map<String,Object>
     * @创建时间 2016年12月24日 23:03:49
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public Map<String, Object> queryForMap(final String sqlMapId, final Object objParam) throws Exception {
        return sqlSession.selectOne(sqlMapId,objParam);
    }

    /**
     * 查询返回List《Map》,含分页
     * @作者 田应平
     * @返回值类型 List<Map<String,Object>>
     * @创建时间 2016年12月24日 23:04:14
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public List<Map<String, Object>> queryForListMap(final String sqlMapId) throws Exception {
        return sqlSession.selectList(sqlMapId);
    }

    /**
     * 查询返回List《Map》,含分页
     * @param sqlMapId
     * @param objParam
     * @throws Exception
     * @作者 田应平
     * @返回值类型 List<Map<String,Object>>
     * @创建时间 2016年12月25日 上午12:47:44
     * @QQ号码 444141300
     * @官网 http://www.fwtai.com
    */
    public List<Map<String, Object>> queryForListMap(final String sqlMapId, final Object objParam) throws Exception {
        return sqlSession.selectList(sqlMapId,objParam);
    }

    /**
     * 返回List集合
     * @作者 田应平
     * @返回值类型 int
     * @创建时间 2016年12月24日 23:00:14
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
     */
    public <E> List<E> selectList(final String sqlMapId) {
        return sqlSession.selectList(sqlMapId);
    }

    /**
     * 带参数的LIST
     * @作者 田应平
     * @返回值类型 int
     * @创建时间 2016年12月24日 23:00:14
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
     */
    public <E> List<E> selectList(final String sqlMapId, final Object objParam) {
        return sqlSession.selectList(sqlMapId,objParam);
    }
}