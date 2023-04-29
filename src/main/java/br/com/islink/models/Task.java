package br.com.islink.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.islink.enums.TaskCategory;
import br.com.islink.enums.TaskStatus;
import br.com.islink.utils.DateAndTimeFormatter;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Task")
@Getter
@Setter
public class Task extends DefaultEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Column(name = "deadline")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime deadline;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskCategory category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task: \n");
        sb.append("  Title: ").append(title).append("\n");
        sb.append("  Description: ").append(description).append("\n");
        sb.append("  Deadline: ").append(deadline).append("\n");
        sb.append("  Category: ").append(category).append("\n");
        sb.append("  Status: ").append(status).append("\n");
        sb.append("  CreatedAt: ").append((this.getCreatedAt() != null) ? DateAndTimeFormatter.format(this.getCreatedAt()) : "null").append("\n");
        sb.append("  UpdatedAt: ").append((this.getUpdatedAt() != null) ? DateAndTimeFormatter.format(this.getUpdatedAt()) : "null").append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, deadline, category, status, this.getCreatedAt(), this.getUpdatedAt());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Task other = (Task) obj;

        return this.title.equals(other.getTitle()) 
            && this.description.equals(other.getDescription())
            && this.deadline.equals(other.getDeadline())
            && this.category.equals(other.getCategory())
            && this.status.equals(other.getStatus())
            && this.getCreatedAt().equals(other.getCreatedAt())
            && this.getUpdatedAt().equals(other.getUpdatedAt());
    }

}
