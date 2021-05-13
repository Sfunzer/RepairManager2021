package nl.furusupport.basic;

enum DeviceState {
    ENDOFLIFE,
    LIFESPANPASSED,
    ADDED,
    OTHERREPAIRS,
    DUPLICATESERIAL,
    DEVICE_NOT_IN_SYSTEM,
    UNKNOWN_ERROR

}

enum DataState {
    IMPORT_SUCCEEDED,
    IMPORT_FAILED,
    DATABASE_NOT_EMPTY
}
