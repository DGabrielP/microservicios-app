package com.example.owner_service.service

import com.example.owner_service.dto.OwnerDTO
import com.example.owner_service.mapper.OwnerMapper
import com.example.owner_service.repository.OwnerRepository
import org.springframework.stereotype.Service

@Service
class OwnerService(private val repository: OwnerRepository) {

    fun getAll(): List<OwnerDTO> =
        repository.findAll().map { OwnerMapper.toDTO(it) }

    fun create(dto: OwnerDTO): OwnerDTO {
        val entity = OwnerMapper.toEntity(dto)
        val saved = repository.save(entity)
        return OwnerMapper.toDTO(saved)
    }
}