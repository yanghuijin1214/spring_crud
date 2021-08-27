package com.crud.persistence;

import com.crud.model.Board;

import java.util.List;

public interface BoardDAO {
    public void create(Board vo) throws Exception;
    public Board read(Integer bno) throws Exception;
    public void update(Board vo) throws Exception;
    public void delete(Integer bno) throws Exception;
    public List<Board> listAll() throws Exception;
    public void updateView(Integer bno) throws Exception;
}
