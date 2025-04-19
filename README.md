# MediConnect
MediConnect is a full-stack healthcare portal built with Spring Boot that acts as a centralized platform connecting patients, doctors, and diagnosis centers. It enables seamless medical data management and fosters efficient communication across the healthcare ecosystem.

🚀 Features
	•	🔐 Secure Login for Patients, Doctors, and Diagnosis Centers
	•	🩺 Doctor-Patient Connect with scheduled appointments and visit tracking
	•	📁 Diagnosis Report Uploads by diagnostic centers, mapped to medical history
	•	💊 Digital Prescriptions created and stored securely
	•	🗂️ Medical History Management — track symptoms, medications, and diagnoses
	•	📅 Upcoming Visits View for patients and doctors
	•	🧾 Complete Patient History — all records, all in one place

📚 Tech Stack
	•	Backend: Spring Boot, Spring Security, Spring Data JPA
	•	Database: MySQL / PostgreSQL
	•	Authentication: JWT-based authentication
	•	Cloud Integration: AWS S3 (for storing medical reports)

🧠 Vision

MediConnect simplifies healthcare management by providing a single source of truth for all medical records. Patients no longer need to carry paper reports. Doctors get full medical context before a visit. Diagnosis centers upload reports directly. It’s a win-win for everyone involved.

🏗️ Modules Overview
	•	Authentication Module: Role-based access (Doctor, Patient, Diagnosis Center)
	•	Patient Module: View history, prescriptions, upcoming visits
	•	Doctor Module: Access patient history, prescribe medications, add diagnosis
	•	Diagnosis Center Module: Upload lab reports and attach to medical history
	•	Admin Module (optional): Monitor and manage users across the system

📦 Future Enhancements
	•	📱 React-based frontend UI (in progress)
	•	📈 Analytics dashboard for doctors
	•	📬 Notifications via email/SMS for appointments
