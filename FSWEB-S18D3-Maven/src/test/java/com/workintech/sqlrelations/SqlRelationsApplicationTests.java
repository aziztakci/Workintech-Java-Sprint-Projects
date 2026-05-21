package com.workintech.sqlrelations;

import com.workintech.sqlrelations.entity.*;
import com.workintech.sqlrelations.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(ResultAnalyzer.class)
class SqlRelationsApplicationTests {
	private DoctorRepository doctorRepository;
	private NurseRepository nurseRepository;
	private OperationRepository operationRepository;
	private PatientRepository patientRepository;
	private SurgeryRepository surgeryRepository;

	@Autowired
	public SqlRelationsApplicationTests(DoctorRepository doctorRepository,
										NurseRepository nurseRepository,
										OperationRepository operationRepository,
										PatientRepository patientRepository,
										SurgeryRepository surgeryRepository) {
		this.doctorRepository = doctorRepository;
		this.nurseRepository = nurseRepository;
		this.operationRepository = operationRepository;
		this.patientRepository = patientRepository;
		this.surgeryRepository = surgeryRepository;
	}

	@DisplayName("Doktor tablosu mevcut mu ? Doğru oluşturulmuş mu ?")
	@Test
	void findDoctorTest(){
		Doctor doctor = new Doctor();
		doctor.setName("Test");
		doctor.setSurname("Test");
		doctor.setProficiency("Cardiology");
		doctorRepository.save(doctor);

		List<Doctor> doctorList = doctorRepository.findAll();
		Doctor doc = doctorList.stream()
				.filter(doctor1 -> doctor1.getProficiency().equals("Cardiology"))
				.collect(Collectors.toList()).get(0);

		assertNotNull(doc);
	}

	@DisplayName("Nurse tablosu mevcut mu ? Doğru oluşturulmuş mu ?")
	@Test
	void findNurseTest(){
		Nurse nurse = new Nurse();
		nurse.setName("Test");
		nurse.setSurname("Test");
		nurse.setProficiency("Cardiology");
		nurseRepository.save(nurse);

		List<Nurse> nurseList = nurseRepository.findAll();
		Nurse foundNurse = nurseList.stream()
				.filter(nurse1 -> nurse1.getProficiency().equals("Cardiology"))
				.collect(Collectors.toList()).get(0);

		assertNotNull(nurse);
	}

	@DisplayName("Nurse tablosu mevcut mu ? Doğru oluşturulmuş mu ?")
	@Test
	void findPatientTest(){
		Patient patient = new Patient();
		patient.setName("Test");
		patient.setSurname("Test");
		patient.setEmail("test@test.com");
		patient.setComplaint("TEST");
		patientRepository.save(patient);

		List<Patient> patientList = patientRepository.findAll();
		Patient foundPatient = patientList.stream()
				.filter(patient1 -> patient1.getEmail().equals("test@test.com"))
				.collect(Collectors.toList()).get(0);

		assertNotNull(foundPatient);
	}

	@DisplayName("Surgery tablosu mevcut mu ? Doğru oluşturulmuş mu ?")
	@Test
	void findSurgeryTest(){
		Patient patient = new Patient();
		patient.setName("Test");
		patient.setSurname("Test");
		patient.setEmail("test@test.com");
		patient.setComplaint("TEST");
		Patient savedPatient = patientRepository.save(patient);

		Doctor doctor = new Doctor();
		doctor.setName("Test");
		doctor.setSurname("Test");
		doctor.setProficiency("Cardiology");
		Doctor savedDoctor = doctorRepository.save(doctor);

		Nurse nurse = new Nurse();
		nurse.setName("Test");
		nurse.setSurname("Test");
		nurse.setProficiency("Cardiology");
		nurseRepository.save(nurse);

		Surgery surgery = new Surgery();
		surgery.setPatientId(savedPatient.getId());
		surgery.setNurseId(nurse.getId());
		surgery.setDoctorId(savedDoctor.getId());
		surgeryRepository.save(surgery);

		List<Surgery> surgeryList = surgeryRepository.findAll();
		Surgery foundSurgery = surgeryList.stream()
				.filter(surgery1 -> surgery1.getDoctorId() == savedDoctor.getId())
				.collect(Collectors.toList()).get(0);

		assertNotNull(foundSurgery);
	}

	@DisplayName("Operation tablosu mevcut mu ? Doğru oluşturulmuş mu ?")
	@Test
	void findOperationTest(){
		Patient patient = new Patient();
		patient.setName("Test");
		patient.setSurname("Test");
		patient.setEmail("test@test.com");
		patient.setComplaint("TEST");
		Patient savedPatient = patientRepository.save(patient);

		Doctor doctor = new Doctor();
		doctor.setName("Test");
		doctor.setSurname("Test");
		doctor.setProficiency("Cardiology");
		Doctor savedDoctor = doctorRepository.save(doctor);

		Operation operation = new Operation();
		operation.setPatientId(savedPatient.getId());
		operation.setDoctorId(savedDoctor.getId());
		operationRepository.save(operation);

		List<Operation> operationList = operationRepository.findAll();
		Operation foundOperation = operationList.stream()
				.filter(operation1 -> operation1.getDoctorId() == 1)
				.collect(Collectors.toList()).get(0);

		assertNotNull(foundOperation);
	}
}
