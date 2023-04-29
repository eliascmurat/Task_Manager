package br.com.islink.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.islink.utils.DateAndTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
        
    @Column(name = "password", nullable = false, length = 255)
    @JsonIgnore
    @Getter(value = AccessLevel.NONE)
    private String password;

    @Column(name = "biography", nullable = true, length = 255)
    private String biography;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: \n");
        sb.append("  Name: ").append(Objects.toString(name, "null")).append("\n");
        sb.append("  Biography: ").append(Objects.toString(biography, "null")).append("\n");
        sb.append("  CreatedAt: ").append((this.getCreatedAt() != null) ? DateAndTimeFormatter.format(this.getCreatedAt()) : "null").append("\n");
        sb.append("  UpdatedAt: ").append((this.getUpdatedAt() != null) ? DateAndTimeFormatter.format(this.getUpdatedAt()) : "null").append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, biography, this.getCreatedAt(), this.getUpdatedAt());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        User other = (User) obj;

        return this.name.equals(other.getName()) 
            && this.biography.equals(other.getBiography())
            && this.getCreatedAt().equals(other.getCreatedAt())
            && this.getUpdatedAt().equals(other.getUpdatedAt());
    }

}
