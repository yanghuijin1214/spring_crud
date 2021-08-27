package com.crud.persistence;

import com.crud.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    private SqlSession session;

    private static String namespace="database";

    @Autowired
    public BoardDAOImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public void create(Board vo) throws Exception {
        session.insert(namespace+".create",vo);
    }

    @Override
    public Board read(Integer bno) throws Exception {
        return session.selectOne(namespace + ".read", bno);
    }

    @Override
    public void update(Board vo) throws Exception {
        session.update(namespace+".update", vo);
    }

    @Override
    public void delete(Integer bno) throws Exception {
        session.delete(namespace+".delete", bno);
    }

    @Override
    public List<Board> listAll() throws Exception {
        return session.selectList(namespace + ".listAll");
    }

    @Override
    public void updateView(Integer bno) throws Exception {
        session.update(namespace+".updateView",bno);
    }
}
