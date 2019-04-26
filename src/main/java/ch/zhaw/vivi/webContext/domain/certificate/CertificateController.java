package ch.zhaw.vivi.webContext.domain.certificate;

import ch.zhaw.vivi.webContext.domain.certificate.dto.CertificateDTO;
import ch.zhaw.vivi.webContext.domain.certificate.dto.CertificateMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class holds all REST endpoints targeted towards the entity certificate.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/certificates")
@Api(
		value = "AnswerController",
		description = "This class holds all REST endpoints targeted towards the entity certificate",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class CertificateController {
	
	private CertificateService certificateService;

	private CertificateMapper certificateMapper;

	public CertificateController() {}

	@Autowired
	public CertificateController (CertificateService certificateService, CertificateMapper certificateMapper) {
		this.certificateService = certificateService;
		this.certificateMapper = certificateMapper;
	}

	/**
	 * This method returns the requested certificate
	 *
	 * @param id	Id of the requested certificate
	 * @return		ResponseEntity with the certificate that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested certificate",
			response = CertificateDTO.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested certificate",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<CertificateDTO> getById(@PathVariable Long id) {
		Certificate certificate = certificateService.findById(id);
			return new ResponseEntity<>(certificateMapper.toDTO(certificate), HttpStatus.OK);
	}

	/**
	 * This method returns all certificates
	 *
	 * @return		ResponseEntity with all exsisting certificates
	 */
	@ApiOperation(
			value = "This endpoint returns all certificates",
			response = Certificate.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<CertificateDTO>> getAll() {
		List<Certificate> certificates = certificateService.findAll();
			return new ResponseEntity<>(certificateMapper.toDTOs(certificates), HttpStatus.OK);
	}

	/**
	 * This method creates an certificate
	 *
	 * @return		ResponseEntity with the certificate that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an certificate",
		response = Certificate.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The certificate to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<CertificateDTO> create(@Valid @RequestBody CertificateDTO certificateDTO) {

		// ensure certificateID is null
		certificateDTO.setId(null);

		// save certificate
		Certificate certificate = certificateMapper.fromDTO(certificateDTO);
		certificateService.save(certificate);
			return new ResponseEntity<>(certificateMapper.toDTO(certificate), HttpStatus.CREATED);
	}

	/**
	 *
	 * @param id	Id from the certificate which will get updated
	 * @param certificateDTO	Updated certificate
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested certificate",
			response = Certificate.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current certificate",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<CertificateDTO> updateById(@PathVariable Long id, @Valid @RequestBody CertificateDTO certificateDTO) {

		// ensure ID's are the same
		certificateDTO.setId(id);

		// update entity
		Certificate certificate = certificateMapper.fromDTO(certificateDTO);
		certificateService.update(certificate);
			return new ResponseEntity<>(certificateMapper.toDTO(certificate), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested certificate
	 *
	 * @param  id Id of the certificate that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested certificate",
		response = Certificate.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested certificate",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		certificateService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
