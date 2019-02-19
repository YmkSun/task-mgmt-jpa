/*package com.ymksun.taskmgmt.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ymksun.taskmgmt.model.Board;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:spring/repository-config.xml")
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
    
    @Test
    public void findById() {
        Optional<Board> board = boardRepository.findById(new Long(10));
        assertNotNull(board);
    }
}
*/