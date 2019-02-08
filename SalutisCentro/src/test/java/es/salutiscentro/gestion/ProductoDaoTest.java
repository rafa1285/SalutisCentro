package es.salutiscentro.gestion;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.PacienteDao;

/**
 * Clase de testeo de repositorio con bdd en memoria (ver
 * application.properties)
 * 
 * @author Rafael Justo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional // Al emplear control transaccional a nivel de servicio los tests nunca podrán
				// completarse a menos que se incluya
// @DataJpaTest //Testeo habitual de capa de DAO, no se puede emplear en este
// caso porque deshabilita la autoconfiguración de SpringBoot
public class ProductoDaoTest {

	@Autowired
	private PacienteDao dao;

	@Test
	public void save() throws DaoException {
		Paciente paciente = new Paciente();
		paciente.setDni("1");
		paciente.setNombre("Rafael");
		paciente.setApellido1("Justo");
		paciente.setApellido2("Sanchez");
		paciente.setFecha_nacimiento(new Date());
		paciente.setDireccion("Huelin");
		Terapeuta terapeuta = new Terapeuta();

		paciente.setTerapeuta_id(terapeuta);

		dao.save(paciente);
	}

}
