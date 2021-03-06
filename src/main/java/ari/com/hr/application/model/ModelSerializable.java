package ari.com.hr.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ari-prasetiyo
 */
@MappedSuperclass
public class ModelSerializable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 100)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "created_time", insertable = true, updatable = false)
    //@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdTime ;//= new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "modified_time", insertable = false, updatable = true)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date modifiedTime; //= new Date();

    @Column(length = 5)
    private String version = "1.0";

    private boolean disabled = false;

    @Column(name = "created_by", length = 50, nullable = true)
    private String createdBy = null;

    @Column(name = "modified_by", length = 50, nullable = true)
    private String modifiedBy = null;

    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    @PrePersist
    public void setCreatedTime() {
        this.createdTime = new Date();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    @PreUpdate
    public void setModifiedTime() {
        this.modifiedTime = new Date();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
