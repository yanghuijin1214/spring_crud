package com.crud.service;

import com.crud.model.Board;
import com.crud.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private BoardDAO dao;

    @Autowired
    public BoardServiceImpl(BoardDAO dao) {
        this.dao = dao;
    }

    @Override
    public void regist(Board board) throws Exception {
        dao.create(board);
    }

    @Override
    public Board read(Integer bno) throws Exception {
        return dao.read(bno);
    }

    @Override
    public void modify(Board board) throws Exception {
        dao.update(board);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        dao.delete(bno);
    }

    @Override
    public List<Board> listAll() throws Exception {
        return dao.listAll();
    }

    @Override
    public void updateView(Integer bno) throws Exception {
        dao.updateView(bno);
    }
}
