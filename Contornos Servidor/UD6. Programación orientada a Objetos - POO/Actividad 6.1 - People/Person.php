<?php
class Person
{
    const species = "Homo Sapiens";

    public $name;
    public $age;
    public $occupation;

    
    public function __construct($name, $age, $occupation){
        $this->name = $name;
        $this->age = $age;
        $this->occupation = $occupation;
    }

    public function introduce(){
        return "Hello, my name is $this->name";
    }
    
    public function describe_job(){
        return "I am currently working as a(n) $this->occupation";
    }

    public static function greet_extraterrestrials ($pecies){
        return "Welcome to Planet Earth $pecies!";
    }
}
