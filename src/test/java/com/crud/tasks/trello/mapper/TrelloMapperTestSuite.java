package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDtos = List.of(new TrelloListDto("1", "test list", false));
        List<TrelloBoardDto> trelloBoardDtos = List.of(new TrelloBoardDto("1", "test board", trelloListDtos));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("test board", trelloBoards.get(0).getName());
        assertEquals(1, trelloListDtos.size());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        List<TrelloList> trelloList = List.of(new TrelloList("1", "test list", false));
        List<TrelloBoard> trelloBoard = List.of(new TrelloBoard("1", "test board", trelloList));

        //When
        List<TrelloBoardDto> trelloBoardsDtos = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals("1", trelloBoardsDtos.get(0).getId());
        assertEquals("test board", trelloBoardsDtos.get(0).getName());
        assertEquals(1, trelloList.size());
    }
}
