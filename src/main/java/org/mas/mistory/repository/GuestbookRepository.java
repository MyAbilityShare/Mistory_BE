package org.mas.mistory.repository;

import org.mas.mistory.entity.Guestbook;
import org.mas.mistory.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
}
