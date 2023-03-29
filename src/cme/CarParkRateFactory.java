package cme;

public class CarParkRateFactory {

    public static CarParkRate createCarParkRate(CarParkKind kind) {
        switch (kind) {
            case STUDENT:
                return new StudentCarPark();
            case STAFF:
                return new StaffCarPark();
            case MANAGEMENT:
                return new ManagementCarPark();
            case VISITOR:
                return new VisitorCarPark();
            default:
                throw new IllegalArgumentException("Unknown CarParkKind");
        }
    }
}
