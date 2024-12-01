package edu.uoc.pac4;

import edu.uoc.pac4.university.University;
import edu.uoc.pac4.university.UniversityException;

/**
 * The DSLab class represents a Distributed Systems Laboratory.
 */
public class DSLab {

    public static final long MIN_CPU_REQUIRED = 1_073_741_824L;
    private String name;
    private String description;
    private int versionMajor;
    private int versionMinor;
    private int versionPatch;
    private long cpu;
    private University university;
    private DSLabStatus status;

    /**
     * Constructs a new DSLab with the specified attributes.
     *
     * @param name          the name of the lab
     * @param description   the description of the lab
     * @param versionMajor  the major version number
     * @param versionMinor  the minor version number
     * @param versionPatch  the patch version number
     * @param cpu           the CPU capacity of the lab
     * @param university    the university associated with the lab
     * @throws DSLabException       if any attribute is invalid
     * @throws UniversityException  if the university is invalid
     */
    public DSLab(String name, String description, int versionMajor, int versionMinor, int versionPatch, long cpu, University university) throws DSLabException, UniversityException {
        setName(name);
        setDescription(description);
        setVersionMajor(versionMajor);
        setVersionMinor(versionMinor);
        setVersionPatch(versionPatch);
        setCpu(cpu);
        setUniversity(university);
        this.status = DSLabStatus.ACTIVE;
    }

    /**
     * Gets the name of the lab.
     *
     * @return the name of the lab
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the lab.
     *
     * @param name the name to set
     * @throws DSLabException if the name is null, empty, or blank
     */
    public void setName(String name) throws DSLabException {
        if (name == null || name.trim().isEmpty()) {
            throw new DSLabException("[ERROR] Name cannot be null, empty or blank");
        }
        this.name = name.trim();
    }

    /**
     * Gets the description of the lab.
     *
     * @return the description of the lab
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the lab.
     *
     * @param description the description to set
     * @throws DSLabException if the description is null
     */
    public void setDescription(String description) throws DSLabException {
        if (description == null) {
            throw new DSLabException("[ERROR] Description cannot be null");
        }
        this.description = description;
    }

    /**
     * Gets the major version number.
     *
     * @return the major version number
     */
    public int getVersionMajor() {
        return versionMajor;
    }

    /**
     * Sets the major version number.
     *
     * @param versionMajor the major version number to set
     * @throws DSLabException if the major version number is negative
     */
    public void setVersionMajor(int versionMajor) throws DSLabException {
        if (versionMajor < 0) {
            throw new DSLabException("[ERROR] Major version cannot be negative");
        }
        this.versionMajor = versionMajor;
    }

    /**
     * Gets the minor version number.
     *
     * @return the minor version number
     */
    public int getVersionMinor() {
        return versionMinor;
    }

    /**
     * Sets the minor version number.
     *
     * @param versionMinor the minor version number to set
     * @throws DSLabException if the minor version number is negative
     */
    public void setVersionMinor(int versionMinor) throws DSLabException {
        if (versionMinor < 0) {
            throw new DSLabException("[ERROR] Minor version cannot be negative");
        }
        this.versionMinor = versionMinor;
    }

    /**
     * Gets the patch version number.
     *
     * @return the patch version number
     */
    public int getVersionPatch() {
        return versionPatch;
    }

    /**
     * Sets the patch version number.
     *
     * @param versionPatch the patch version number to set
     * @throws DSLabException if the patch version number is negative
     */
    public void setVersionPatch(int versionPatch) throws DSLabException {
        if (versionPatch < 0) {
            throw new DSLabException("[ERROR] Patch version cannot be negative");
        }
        this.versionPatch = versionPatch;
    }

    /**
     * Gets the version of the lab.
     *
     * @return the version of the lab in the format major.minor.patch
     */
    public String getVersion() {
        return versionMajor + "." + versionMinor + "." + versionPatch;
    }

    /**
     * Gets the CPU capacity of the lab.
     *
     * @return the CPU capacity of the lab
     */
    public long getCpu() {
        return cpu;
    }

    /**
     * Sets the CPU capacity of the lab.
     *
     * @param cpu the CPU capacity to set
     * @throws DSLabException if the CPU capacity is less than the minimum required
     */
    public void setCpu(long cpu) throws DSLabException {
        if (cpu < MIN_CPU_REQUIRED) {
            throw new DSLabException("[ERROR] This server does not have enough CPU");
        }
        this.cpu = cpu;
    }

    /**
     * Gets the university associated with the lab.
     *
     * @return the university associated with the lab
     */
    public University getUniversity() {
        return university;
    }

    /**
     * Sets the university associated with the lab.
     *
     * @param university the university to set
     * @throws DSLabException if the university is null
     */
    public void setUniversity(University university) throws DSLabException {
        if (university == null) {
            throw new DSLabException("[ERROR] University cannot be null");
        }
        this.university = university;
    }

    /**
     * Gets the status of the lab.
     *
     * @return the status of the lab
     */
    public DSLabStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the lab.
     *
     * @param status the status to set
     */
    public void setStatus(DSLabStatus status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the lab.
     *
     * @return a string representation of the lab
     */
    @Override
    public String toString() {
        return name + System.lineSeparator() +
                "\tDescription: " + description + System.lineSeparator() +
                "\tVersion: " + getVersion() + System.lineSeparator() +
                "\tStatus: " + status + System.lineSeparator() +
                "\tCPU: " + cpu + System.lineSeparator() +
                "\tUniversity: " + university;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DSLab dsLab = (DSLab) obj;
        return name.equals(dsLab.name) && university.equals(dsLab.university);
    }
}
