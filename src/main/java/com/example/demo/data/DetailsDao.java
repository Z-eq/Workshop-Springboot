package com.example.demo.data;

import com.example.demo.Entity.Details;

import java.util.Collection;

public interface DetailsDao {

    Details create(Details details);
    Details findById(int id);
    Collection<Details> findAll();
    Details update(Details details);
    void delete(int id);

}
