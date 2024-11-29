package edu.uoc.pac4;

import edu.uoc.pac4.university.University;
import edu.uoc.pac4.university.UniversityException;

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

    public String getName() {
        return name;
    }

    public void setName(String name) throws DSLabException {
        if (name == null || name.trim().isEmpty()) {
            throw new DSLabException("[ERROR] Name cannot be null, empty or blank");
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws DSLabException {
        if (description == null) {
            throw new DSLabException("[ERROR] Description cannot be null");
        }
        this.description = description;
    }

    public int getVersionMajor() {
        return versionMajor;
    }

    public void setVersionMajor(int versionMajor) throws DSLabException {
        if (versionMajor < 0) {
            throw new DSLabException("[ERROR] Major version cannot be negative");
        }
        this.versionMajor = versionMajor;
    }

    public int getVersionMinor() {
        return versionMinor;
    }

    public void setVersionMinor(int versionMinor) throws DSLabException {
        if (versionMinor < 0) {
            throw new DSLabException("[ERROR] Minor version cannot be negative");
        }
        this.versionMinor = versionMinor;
    }

    public int getVersionPatch() {
        return versionPatch;
    }

    public void setVersionPatch(int versionPatch) throws DSLabException {
        if (versionPatch < 0) {
            throw new DSLabException("[ERROR] Patch version cannot be negative");
        }
        this.versionPatch = versionPatch;
    }

    public String getVersion() {
        return versionMajor + "." + versionMinor + "." + versionPatch;
    }

    public long getCpu() {
        return cpu;
    }

    public void setCpu(long cpu) throws DSLabException {
        if (cpu < MIN_CPU_REQUIRED) {
            throw new DSLabException("[ERROR] This server does not have enough CPU");
        }
        this.cpu = cpu;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) throws DSLabException {
        if (university == null) {
            throw new DSLabException("[ERROR] University cannot be null");
        }
        this.university = university;
    }

    public DSLabStatus getStatus() {
        return status;
    }

    public void setStatus(DSLabStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name + System.lineSeparator() +
                "\tDescription: " + description + System.lineSeparator() +
                "\tVersion: " + getVersion() + System.lineSeparator() +
                "\tStatus: " + status + System.lineSeparator() +
                "\tCPU: " + cpu + System.lineSeparator() +
                "\tUniversity: " + university;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DSLab dsLab = (DSLab) obj;
        return name.equals(dsLab.name) && university.equals(dsLab.university);
    }
}