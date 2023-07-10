package Capstone.Capstone.Service.Impl;

import Capstone.Capstone.Repository.CalendarRepository;
import Capstone.Capstone.Repository.MemberRepository;
import Capstone.Capstone.Service.CalendarService;
import Capstone.Capstone.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
class CalendarServiceImplTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private CalendarService calendarService;


    @Test
    void join() {
    }

    @Test
    void findAllRecord() {
    }

    @Test
    void findAnnualRecord() {
    }

    @Test
    void findMonthlyRecord() {
    }

    @Test
    void findDateRecord() {
    }
}