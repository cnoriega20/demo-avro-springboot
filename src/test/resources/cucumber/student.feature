Feature: Student Kafka test

  Scenario: Consume student from Kafka topic
    Given a student with data from "src/test/resources/messages/student.json"
    When the student is consumed from the Kafka topic
    Then the student name should be "John Doe"
