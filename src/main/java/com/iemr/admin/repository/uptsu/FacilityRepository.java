/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.admin.repository.uptsu;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.uptsu.M_FacilityMapping;

import jakarta.transaction.Transactional;

@Repository
public interface FacilityRepository extends CrudRepository<M_FacilityMapping, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE M_FacilityMapping b SET b.deleted = true,"
			+ "b.lastModDate = :lastModDate,b.modifiedBy = :modifiedBy WHERE b.providerServiceMapID = :providerServiceMapID")
	Integer updatedeleteStatus(@Param("providerServiceMapID") int providerServiceMapID,
			@Param("lastModDate") Timestamp lastModDate,@Param("modifiedBy") String modifiedBy);

}
