package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.response.VehiculoResponseDto;
import com.backend.skyblue.models.Vehiculo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface VehiculoMapper {
	Integer PAGINATION_OFFSET = 1;

	static VehiculoResponseDto buildResponseDto(Vehiculo vehiculo) {

		return VehiculoResponseDto.builder()
				.id(vehiculo.getId())
				.padron(vehiculo.getPadron())
				.placa(vehiculo.getPlaca())
				.clase(vehiculo.getClase())
				.marca(vehiculo.getMarca())
				.modelo(vehiculo.getModelo())
				.color(vehiculo.getColor())
				.tipo(vehiculo.getTipo())
				.tarjetaPropiedad(vehiculo.getTarjetaPropiedad())
				.anioFabricacion(vehiculo.getAnioFabricacion())
				.nroMoto(vehiculo.getNroMoto())
				.pesoNeto(vehiculo.getPesoNeto())
				.pesoBruto(vehiculo.getPesoBruto())
				.nroAsientos(vehiculo.getNroAsientos())
				.nroPasajeros(vehiculo.getNroPasajeros())
				.tipoCombustible(vehiculo.getTipoCombustible())
				.carroceria(vehiculo.getCarroceria())
				.SerieMotor(vehiculo.getSerieMotor())
				.nroCilindros(vehiculo.getNroCilindros())
				.nroRuedas(vehiculo.getNroRuedas())
				.longitud(vehiculo.getLongitud())
				.altura(vehiculo.getAltura())
				.ancho(vehiculo.getAncho())
				.cargaUtil(vehiculo.getCargaUtil())
				.nroEjes(vehiculo.getNroEjes())
				.kilomentraje(vehiculo.getKilomentraje())
				.ruta(vehiculo.getRuta())   //.ruta(RutaMapper.buildResponseDto(vehiculo.getRuta()))
				.build();
	}

	public static Vehiculo buildRequestDto(VehiculoRequestDto vehiculoRequestDto) {

		return Vehiculo.builder()
				.id(vehiculoRequestDto.getId())
				.placa(vehiculoRequestDto.getPlaca())
				.padron(vehiculoRequestDto.getPadron())
				.clase(vehiculoRequestDto.getClase())
				.marca(vehiculoRequestDto.getMarca())
				.modelo(vehiculoRequestDto.getModelo())
				.color(vehiculoRequestDto.getColor())
				.tipo(vehiculoRequestDto.getTipo())
				.tarjetaPropiedad(vehiculoRequestDto.getTarjetaPropiedad())
				.anioFabricacion(vehiculoRequestDto.getAnioFabricacion())
				.nroMoto(vehiculoRequestDto.getNroMoto())
				.pesoNeto(vehiculoRequestDto.getPesoNeto())
				.pesoBruto(vehiculoRequestDto.getPesoBruto())
				.nroAsientos(vehiculoRequestDto.getNroAsientos())
				.nroPasajeros(vehiculoRequestDto.getNroPasajeros())
				.tipoCombustible(vehiculoRequestDto.getTipoCombustible())
				.carroceria(vehiculoRequestDto.getCarroceria())
				.SerieMotor(vehiculoRequestDto.getSerieMotor())
				.nroCilindros(vehiculoRequestDto.getNroCilindros())
				.nroRuedas(vehiculoRequestDto.getNroRuedas())
				.longitud(vehiculoRequestDto.getLongitud())
				.altura(vehiculoRequestDto.getAltura())
				.ancho(vehiculoRequestDto.getAncho())
				.cargaUtil(vehiculoRequestDto.getCargaUtil())
				.nroEjes(vehiculoRequestDto.getNroEjes())
				.kilomentraje(vehiculoRequestDto.getKilomentraje())
				.ruta(RutaMapper.buildRequestDto(vehiculoRequestDto.getRuta()))
				.build();
	}

	static Vehiculo buildEntidadFromDto(VehiculoRequestDto vehiculoRequestDto) {
		return Vehiculo.builder()
				.id(vehiculoRequestDto.getId())
				.placa(vehiculoRequestDto.getPlaca())
				.padron(vehiculoRequestDto.getPadron())
				.clase(vehiculoRequestDto.getClase())
				.marca(vehiculoRequestDto.getMarca())
				.modelo(vehiculoRequestDto.getModelo())
				.color(vehiculoRequestDto.getColor())
				.tipo(vehiculoRequestDto.getTipo())
				.tarjetaPropiedad(vehiculoRequestDto.getTarjetaPropiedad())
				.anioFabricacion(vehiculoRequestDto.getAnioFabricacion())
				.nroMoto(vehiculoRequestDto.getNroMoto())
				.pesoNeto(vehiculoRequestDto.getPesoNeto())
				.pesoBruto(vehiculoRequestDto.getPesoBruto())
				.nroAsientos(vehiculoRequestDto.getNroAsientos())
				.nroPasajeros(vehiculoRequestDto.getNroPasajeros())
				.tipoCombustible(vehiculoRequestDto.getTipoCombustible())
				.carroceria(vehiculoRequestDto.getCarroceria())
				.SerieMotor(vehiculoRequestDto.getSerieMotor())
				.nroCilindros(vehiculoRequestDto.getNroCilindros())
				.nroRuedas(vehiculoRequestDto.getNroRuedas())
				.longitud(vehiculoRequestDto.getLongitud())
				.altura(vehiculoRequestDto.getAltura())
				.ancho(vehiculoRequestDto.getAncho())
				.cargaUtil(vehiculoRequestDto.getCargaUtil())
				.nroEjes(vehiculoRequestDto.getNroEjes())
				.kilomentraje(vehiculoRequestDto.getKilomentraje())
				.ruta(RutaMapper.buildRequestDto(vehiculoRequestDto.getRuta()))
				.build();
	}

	static PageResponseDto buildVehiculoPageResponseDto(
			Page<Vehiculo> vehiculoPage) {
		var vehiculos = VehiculoMapper.buildListResponseEntities(vehiculoPage.getContent());

		return PageResponseDto.builder()
				.data(vehiculos)
				.pagination(PaginationMapper.buildPaginationResponseFromPage(vehiculoPage))
				.build();
	}

	static List<VehiculoResponseDto> buildListResponseEntities(List<Vehiculo> vehiculos) {
		return vehiculos.stream()
				.map(vjs -> VehiculoMapper.buildResponseDto(vjs))
				.collect(Collectors.toList());
	}


}
