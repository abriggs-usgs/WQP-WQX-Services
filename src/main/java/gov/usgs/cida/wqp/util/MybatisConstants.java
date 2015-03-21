package gov.usgs.cida.wqp.util;
public interface MybatisConstants {
	String CODES_MAPPER_NAMESPACE = "dataMapper";
	String STATIONS_MAPPER_NAMESPACE = "dataMapper";
	String RESULTS_MAPPER_NAMESPACE = STATIONS_MAPPER_NAMESPACE;
	String STATIONS_KML_SELECTID = STATIONS_MAPPER_NAMESPACE + ".stationsKMLSelect";
	String STATIONS_WQX_SELECTID = STATIONS_MAPPER_NAMESPACE + ".stationsWQXSelect";
	String STATIONS_WQX_COUNTID = STATIONS_MAPPER_NAMESPACE + ".stationsWQXCount";
	String SIMPLE_STATIONS_SELECTID = STATIONS_MAPPER_NAMESPACE + ".simpleStationsSelect";
	String BIOLOGICAL_STATIONS_WQX_COUNTID = RESULTS_MAPPER_NAMESPACE + ".biologicalstationsWQXCount";
	String BIOLOGICAL_RESULTS_WQX_COUNTID = RESULTS_MAPPER_NAMESPACE + ".biologicalResultsWQXCount";
	String ENTRIES = "ENTRIES";
	String DATA_SOURCE = "DATA_SOURCE";
}