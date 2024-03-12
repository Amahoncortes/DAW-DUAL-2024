<?php

class NotaController {

    public $nombre;
    public $view;
    private $productoServicio;
    
    const VIEW_FOLDER='product';

    public function __construct() {
        $this->view = self::VIEW_FOLDER.DIRECTORY_SEPARATOR.'list_note';
        $this->nombre = '';
        $this->productoServicio = new NotaServicio();
    }

    /* List all notes */

    public function list() {
        $this->nombre = 'Listado de Productos';

        return $this->productoServicio->getAllProducts();
    }

    /* Load note for edit */

 

    /* Create or update note */

    public function save() {
        $this->view =self::VIEW_FOLDER.DIRECTORY_SEPARATOR.'edit_note';
        $this->page_title = 'Editar nota';

        if (isset($_POST["id"]) && trim($_POST["id"]) !== "" && is_numeric($_POST["id"])) {
            $id = (int) $_POST["id"];
        } else {
            $id = null;
        }

        if (isset($_POST["title"])) {
            $title = $_POST["title"];
        }
        if (isset($_POST["content"])) {
            $content = $_POST["content"];
        }
        
        $nota = new Producto();
        $nota->setTitulo($title);
        $nota->setContenido($content);
        $nota->setId($id);
        
         $notaGuardada = $this->productoServicio->save($nota, $_FILES["fichero"]);
        //para saber si ha habido error o no
                  

//        if ($notaGuardada == null) {
//            $notaGuardada->setStatus(Util::OPERATION_NOK);
//        } else {
//            $notaGuardada->setStatus(Util::OPERATION_OK);
//        }


        return $notaGuardada;
    }

    /* Confirm to delete */

    public function confirmDelete() {
        $this->page_title = 'Eliminar nota';
        $this->view = self::VIEW_FOLDER.DIRECTORY_SEPARATOR.'confirm_delete_note';
        return $this->productoServicio->getNoteById($_GET["id"]);
    }

    /* Delete */

    public function delete(): bool {
        $this->page_title = 'Listado de notas';
        $this->view =self::VIEW_FOLDER.DIRECTORY_SEPARATOR. 'delete_note';
        return $this->productoServicio->deleteNoteById($_POST["id"]);
    }

}

?>