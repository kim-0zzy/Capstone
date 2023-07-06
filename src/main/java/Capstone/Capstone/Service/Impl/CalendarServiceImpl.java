package Capstone.Capstone.Service.Impl;

import Capstone.Capstone.Entity.Calendar;
import Capstone.Capstone.Exception.NotFoundIdException;
import Capstone.Capstone.Repository.CalendarRepository;
import Capstone.Capstone.Service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("CalendarService")
@Transactional
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    @Override
    public Long join(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar.getId();
    }

    @Override
    public List<Calendar> findAllRecord(Long id) throws NotFoundIdException {
        return calendarRepository.findByOwnerId(id);
    }

    @Override
    public List<Calendar> findAnnualRecord(Long id, int year) throws NotFoundIdException {
        return calendarRepository.findByOwnerIdWithYear(id, year);
    }

    @Override
    public List<Calendar> findMonthlyRecord(Long id, int year, int month) throws NotFoundIdException {
        return calendarRepository.findByOwnerIdWithYM(id, year, month);
    }

    @Override
    public Optional<Calendar> findDateRecord(Long id, int year, int month, int day) throws NotFoundIdException {
        return calendarRepository.findByOwnerIdWithYMD(id, year, month, day);
    }
}
