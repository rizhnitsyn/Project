package by.itacademy.repository;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public RoomRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Room> findRooms(LocalDate dayOfArrival, LocalDate dayOfDeparture, RoomType roomType, int numberOfPlaces) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Room> rooms = entityManager
                .createQuery("select r from Room r where "
                        + "r.type=:type and r.numberOfPlaces=:numberOfPlaces "
                        + "and r.id NOT IN (SELECT r1.id FROM Application a join a.room r1 "
                        + "where :arrivaldate < a.dayOfDeparture and :arrivaldate > a.dayOfArrival "
                        + "or a.dayOfArrival < :departuredate and a.dayOfArrival > :arrivaldate)", Room.class)
                .setParameter("arrivaldate", dayOfArrival)
                .setParameter("departuredate", dayOfDeparture)
                .setParameter("type", roomType)
                .setParameter("numberOfPlaces", numberOfPlaces)
                .getResultList();

        transaction.commit();
        return rooms;
    }

    }
