package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.DiagnosisCentreDto;
import com.nikhil.springboot.MediConnect.dto.PatientDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.repository.DiagnosisCentreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisCentreServiceImpl implements DiagnosisCentreService {


    @Autowired
    DiagnosisCentreRepository diagnosisCentreRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public DiagnosisCentre getDiagnosisCentreById(Long id) {
        return null;
    }

    @Override
    public DiagnosisCentreDto addNewDiagnosisCentre(DiagnosisCentreDto diagnosisCentreDto) {
        DiagnosisCentre diagnosisCentre = modelMapper.map(diagnosisCentreDto, DiagnosisCentre.class);
        return modelMapper.map(diagnosisCentreRepository.save(diagnosisCentre) , DiagnosisCentreDto.class);
    }
}
