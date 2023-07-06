package Capstone.Capstone.Service;

import Capstone.Capstone.Entity.Calendar;
import Capstone.Capstone.Exception.NotFoundIdException;

import java.util.List;
import java.util.Optional;

public interface CalendarService {
    public Long join(Calendar calendar);
    public List<Calendar> findAllRecord(Long id) throws NotFoundIdException;
    public List<Calendar> findAnnualRecord(Long id, int year) throws NotFoundIdException;
    public List<Calendar> findMonthlyRecord(Long id, int year, int month) throws NotFoundIdException;
    public Optional findDateRecord(Long id, int year, int month, int day) throws NotFoundIdException;

}
