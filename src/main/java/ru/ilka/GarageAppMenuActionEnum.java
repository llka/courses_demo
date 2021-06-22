package ru.ilka;

public enum GarageAppMenuActionEnum {
    EXIT(0),
    ADD_VEHICLE(1),
    UPDATE_VEHICLE_BY_ID(2),
    FIND_VEHICLE_BY_NAME(3),
    FIND_VEHICLE_BY_ID(4),
    GET_ALL_VEHICLES(5);

    private final int code;

    GarageAppMenuActionEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GarageAppMenuActionEnum findActionByCode(int code) throws GarageAppMenuException {
        for (GarageAppMenuActionEnum action : values()) {
            if (code == action.getCode()) {
                return action;
            }
        }
        throw new GarageAppMenuException(String.format("Not found menu action with code: %s.", code));
    }
}
