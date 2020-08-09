package com.cqupt.bcirs.tests;

import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.service.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-20 23:29
 */
public class ListTest {
    @Test
    public void test(){
        Card card = new Card();
        List<Card> cardList = new ArrayList<>();

        card.setStatu(Status.VALID);
        card.setDate("2002-9");
        card.setIssuer("中国农业银行");
        card.setAccount("13245465465465873");
        card.setNumber(1);

        cardList.add(card);



    }
}
