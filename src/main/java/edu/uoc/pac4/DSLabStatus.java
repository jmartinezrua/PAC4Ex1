package edu.uoc.pac4;

/**
 * Enumeration representing the status of a DSLab.
 */
public enum DSLabStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    MAINTENANCE("Maintenance");

    private final String status;

    /**
     * Constructor for DSLabStatus.
     *
     * @param status the status as a String
     */
    DSLabStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the status as a String.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns a string representation of the status in uppercase.
     *
     * @return the status in uppercase enclosed in square brackets
     */
    @Override
    public String toString() {
        return "[" + status.toUpperCase() + "]";
    }
}
