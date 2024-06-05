package com.alvaro.curso.springboot.jpa.springbootjpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.alvaro.curso.springboot.jpa.springbootjpa.dto.PersonDto;
import com.alvaro.curso.springboot.jpa.springbootjpa.entities.Person;
import com.alvaro.curso.springboot.jpa.springbootjpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// list();
		// findOne();
		// create();
		update();
		// delete();
		// delete2();
		// personalizedQueries();
		// personalizedQueries2();
		// personalizedQueriesDistinct();
		// personalizedQueriesConcatUpperAndLowerCase();
		// personalizedQueriesBetween();
		// queriesFunctionAggregation();
		// subQueries();
		// whereIn();

		
	}

	@Transactional(readOnly = true)
	public void whereIn() {

		System.out.println("======= consulta where in =======");
		List<Person> persons = repository.getpersonsByIds(Arrays.asList(1L, 2L, 5L, 7L));
		persons.forEach(System.out::println);

	}


	@Transactional(readOnly = true)
	public void subQueries() {

		System.out.println("======= consulta por el nombre mas corto y su largo =======");
		List<Object[]> registers = repository.getShorterName();
		registers.forEach(reg -> System.out.println("name=" + reg[0] + ", length=" + reg[1]));

		System.out.println("======= consulta para obtener el ultimo registro de persona =======");
		Optional<Person> optionalPerson = repository.getLastRegistration();
		optionalPerson.ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
		public void queriesFunctionAggregation() {

			System.out.println("======= consulta con el total de registros de la tabla =======");
			Long count = repository.getTotalPerson();
			System.out.println(count);
			
			System.out.println("======= consulta con el valor minimo del id  =======");
			Long min = repository.getMinId();
			System.out.println(min);
			
			System.out.println("======= consulta con el valor maximo del id =======");
			Long max = repository.getMaxId();
			System.out.println(max);
			
			System.out.println("======= consulta con el nombre y su largo =======");
			List<Object[]> regs = repository.getPersonNameLength();
			regs.forEach(reg -> System.out.println("name=" + reg[0] + ", length=" + reg[1]));
			
			System.out.println("======= consulta con el nombre mas corto =======");
			Integer minLengthame = repository.getMinLengthName();
			System.out.println(minLengthame);

			System.out.println("======= consulta con el nombre mas largo =======");
			Integer maxLengthame = repository.getMaxLengthName();
			System.out.println(maxLengthame);

			System.out.println("======= consulta resumen de funciones de agregacion min, max, sum, avg, count =======");
			Object[] resumeReg = (Object[]) repository.getResumeAggregationFunction();
			System.out.println("min=" + resumeReg[0] + ", max=" + resumeReg[1] + ", sum=" + resumeReg[2] + ", avg=" + resumeReg[3] + ", count=" + resumeReg[4]);
								
		}
		
	@Transactional(readOnly = true)
		public void personalizedQueriesBetween() {

			System.out.println("======= consulta por rangos =======");
			List<Person> persons = repository.findByIdBetweenOrderByNameAsc(2L, 5L);
			persons.forEach(System.out::println);

			persons = repository.findByNameBetweenOrderByNameDescLastnameDesc("J", "Q");
			persons.forEach(System.out::println);

			persons = repository.findAllByOrderByNameDesc();
			persons.forEach(System.out::println);

		}

	@Transactional(readOnly = true)
		public void personalizedQueriesConcatUpperAndLowerCase() {

			System.out.println("======= consulta nombres y apellidos de personas =======");
			List<String> names = repository.findFullNameConcat();
			names.forEach(System.out::println);

			System.out.println("======= consulta nombres y apellidos mayuscula =======");
			names = repository.findFullNameConcatUpper();
			names.forEach(System.out::println);

			System.out.println("======= consulta nombres y apellidos mainuscula =======");
			names = repository.findFullNameConcatLower();
			names.forEach(System.out::println);

			System.out.println("======= consulta personalizada persona upper y lower case =======");
			List<Object[]> regs = repository.findAllPersonDataListCase();
			regs.forEach(reg -> System.out.println("id=" + reg[0] + ", nombre=" + reg[1] + ", apellido=" + reg[2] + ", lenguaje=" + reg[3]));

		}
	

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct() {

		System.out.println("======= consulta con nombres de persona =======");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println("======= consulta con nombres unicos de persona =======");
		names = repository.findAllNamesDistinct();
		names.forEach(System.out::println);

		System.out.println("======= consulta con lenguajes de programacion unicas =======");
		List<String> languages = repository.findAllProgrammingLanguageDistinct();
		languages.forEach(System.out::println);

		System.out.println("======= consulta con total de lenguajes de programacion unicas =======");
		Long totalLanguage = repository.findAllProgrammingLanguageDistinctCount();
		System.out.println("Total de lenguajes de programación: " + totalLanguage);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2() {

		System.out.println("========================= consulta por objeto persona y lenguaje de programación =========================");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(reg -> System.out.println("programming_language=" + reg[1] + ", person=" + reg[0]));
		
		System.out.println("======= consulta que puebla y devulve objeto entity de una instancia personalizada =======");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);

		
		System.out.println("======= consulta que puebla y devulve objeto dto de una clase personalizada =======");
		List<PersonDto> personsDto = repository.findAllPersonDto();
		personsDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("========================= consulta solo el nombre por el id =========================");
		System.out.println("Ingrese el id:");
		Long id = scanner.nextLong();
		
		System.out.println("======= mostrando solo el nombre =======");
		String name = repository.getNameById(id);
		System.out.println(name);
		
		System.out.println("======= mostrando solo el id =======");
		Long idDb = repository.getId(id);
		System.out.println(idDb);
		
		System.out.println("======= mostrando nombre completo con concat =======");
		String fullName = repository.getFullNameById(id);
		System.out.println(fullName);

		System.out.println("======= consulta por campos personalizados por el id =======");
		Object[] personReg = (Object[]) repository.obtenerPersonDataById(id);
		System.out.println("id=" + personReg[0] + ", nombre=" + personReg[1] + ", apellido=" + personReg[2] + ", lenguaje=" + personReg[3]);
		
		System.out.println("======= consulta por campos personalizados lista =======");
		List<Object[]> regs = repository.obtenerPersonDataList();
		regs.forEach(reg -> System.out.println("id=" + reg[0] + ", nombre=" + reg[1] + ", apellido=" + reg[2] + ", lenguaje=" + reg[3]));

		scanner.close();
	}

	@Transactional
	public void delete() {
		
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar:");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void delete2() {
		
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(repository::delete,
		() -> System.out.println("Lo sentimos no exite la persona con ese id!"));

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programación:");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personUpdated = repository.save(person);
			System.out.println(personUpdated);
		});

		scanner.close();

	}

	@Transactional
	public void create() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre:");
		String name = scanner.next();
		System.out.println("Ingrese el apellido:");
		String lastname = scanner.next();
		System.out.println("Ingrese el lenguaje de programación:");
		String programmingLanguage = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);

		Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		/* Person person = null;
		Optional<Person> optionalPerson = repository.findById(8L);
		if (optionalPerson.isPresent()) {
			person = optionalPerson.get();
		}
		System.out.println(person); */

		// LAS DOS SIGUIENTES LÍNEAS MUESTRAN POR PANTALLA LO MISMO
		// repository.findById(1L).ifPresent(person -> System.out.println(person));
		// repository.findById(1L).ifPresent(System.out::println);

		repository.findOne(3L).ifPresent(System.out::println);
		repository.findOneName("Pepe").ifPresent(System.out::println);
		repository.findOneLikeName("ri").ifPresent(System.out::println);
		repository.findByNameContaining("se").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void list() {

		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
		// List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java", "Andres");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Andres");
		persons.stream().forEach(person -> System.out.println(person));

		List<Object[]> personsValues = repository.obtenerPersonData("Python", "Pepe");
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
		});

	}

}
