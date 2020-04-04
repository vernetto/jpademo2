package com.example.jpademo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { StudentJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
@EnableJpaRepositories(basePackages="com.example.jpademo2")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.jpademo2")
@EntityScan("com.example.jpademo2.*")

   public class InMemoryDBTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Student student = new Student(1, "john");
        studentRepository.save(student);

        Optional<Student> student2 = studentRepository.findById(1L);
        assertEquals("john", student2.get().getName());
    }
}