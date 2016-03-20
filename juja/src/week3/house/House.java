package week3.house;

import week3.house.apartment.LivingApartment;
import week3.house.staff.Cleaner;
import week3.house.staff.Housemaid;

public class House {

    private Floor[] floors;
    private Cleaner[] cleaners; // TODO ? ??? ???? ?????? ?? Floor

    public House(int floorsCount, int apartmentsOnFloor) {
        NumberGenerator numbers = new NumberGenerator();

        cleaners = new Cleaner[floorsCount];

        floors = new Floor[floorsCount];
        for (int index = 0; index < floorsCount; index++) {
            floors[index] = new Floor(index + 1, apartmentsOnFloor, numbers);
        }
    }

    public void settle(Owner owner) {
        System.out.println("Try to settle " + owner.toString() + "\n");
        for (Floor floor : floors) {
            LivingApartment apartment = floor.getFreeApartment();
            if (apartment != null) {
                apartment.addOwner(owner);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String result = "House:\n";
        for (Floor floor : floors) {
            result += floor.toString() + "\n";
        }
        return result;
    }

    public void addCleaner(Cleaner cleaner) {
        int floor = nextCleanerPlace();
        this.cleaners[floor] = cleaner;
        this.floors[floor].setCleaner(cleaner);
    }

    private int nextCleanerPlace() {
        for (int index = 0; index < cleaners.length; index++) {
            if (cleaners[index] == null) {
                return index;
            }
        }
        throw new RuntimeException("No place for new cleaner");
    }
}
