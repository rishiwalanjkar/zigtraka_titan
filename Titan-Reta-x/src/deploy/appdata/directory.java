package deploy.appdata;

public interface directory {
String rootFolderPath="/sdcard/Reta-X";
String titanWatchesPath=rootFolderPath+"/Titan";
String titanNebulaPath=titanWatchesPath+"/Nebula";
String titanNebulaContentPath=titanNebulaPath+"/Content";
String titanNebulaPicturePath=titanNebulaPath+"/Picture";
String titanNebulaReviewPath=titanNebulaPath+"/Review";
String titanNebulaMiscPath=titanNebulaPath+"/Misc";
String databaseFolderPath=titanWatchesPath+"/Database";
String databaseFilePath=databaseFolderPath+"/titanwc.sqlite";
String logFolderPath=titanWatchesPath+"/Log";
}
