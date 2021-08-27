package com.crud.service;

import com.crud.model.Board;

import java.util.List;

public interface BoardService {
    public void regist(Board board) throws Exception;
    public Board read(Integer bno) throws Exception;
    public void modify(Board board) throws Exception;
    public void remove(Integer bno) throws Exception;
    public List<Board> listAll() throws Exception;
    public void updateView(Integer bno) throws Exception;
}
