<?php
include_once 'db.php';

    $i1 = $_POST['i1'];
    $i2 = $_POST['i2'];
    $i3 = $_POST['i3'];
    $i4 = $_POST['i4'];
    $i5 = $_POST['i5'];
    $i6 = $_POST['i6'];
    $i7 = $_POST['i7'];

    try {
    $db = new Database();

    $stmt = $db->connect()->prepare("INSERT INTO `studmast`(`StudID`, `lname`, `fname`, `mi`, `cno`, `course`, `year`) VALUES (:a, :b, :c, :d, :e, :f, :g);");
    $stmt->bindParam('a', $i1);
    $stmt->bindParam('b', $i2);
    $stmt->bindParam('c', $i3);
    $stmt->bindParam('d', $i4);
    $stmt->bindParam('e', $i5);
    $stmt->bindParam('f', $i6);
    $stmt->bindParam('g', $i7);
    if(!$stmt->execute()) {
        $stmt = null;
        die();
    }

    }catch(ErrorException $e) {

        echo $e->getMessage();
    }
