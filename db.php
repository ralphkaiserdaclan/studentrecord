<?php

class Database{
    
    private $dbname;
    private $username;
    private $password;
    private $server;

    public function connect() {
        
        $this->dbname = "mydb";
        $this->username = "root";
        $this->password = "";
        $this->server = "localhost";

        try {
        $pdo = new PDO('mysql:host='.$this->server.";dbname=".$this->dbname,$this->username,$this->password);
        $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);
        return $pdo;
        }catch(PDOException $e) {
            echo "Connection to the database failed! ". $e->getMessage();
            die();
        }

    }
}
?>
