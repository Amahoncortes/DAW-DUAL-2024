<?php

namespace App\Entity;

use App\Validator as AppValidator;
use App\Repository\ProductoRepository;
use DateTimeInterface;
use Doctrine\ORM\Mapping as ORM;
use InvalidArgumentException;
use Symfony\Component\Validator\Constraints as Assert;

# Entidad que representa un producto
#[ORM\Entity(repositoryClass: ProductoRepository::class)]
#[AppValidator\ProductoNombreUnico]
class Producto
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private int $id;

    public function __construct()
    {
        $this->id = 0; // Inicializa la propiedad $id con el valor 0
    }

    /*
    Incorpora una validación básica previa a la creación de una entidad
    de forma que no se puedan crear nuevas entidades si no se cumplen determinadas reglas.
     Por ejemplo, que la propiedad de tipo String deba tener más de 2 y menos de 5 caracteres.
    */
    #[Assert\NotBlank]
    #[Assert\Length(
        min: 2,
        max: 20,
        minMessage: 'El nombre debe tener al menos {{ limit }} caracteres',
        maxMessage: 'El nombre debe tener como maximo {{ limit }} caracteres'
    )]
    #[ORM\Column(name: 'nombre')]
    private string $nombre;

    #[ORM\Column(name: 'precio', type: 'float')]
    private float $precio;

    #[ORM\Column(name: 'fecha', type: 'datetime')]
    private DateTimeInterface $fechaCreacion;


    #[ORM\ManyToOne(inversedBy: "productos")]
    #[ORM\JoinColumn(nullable: false)]
    #[Assert\NotBlank]

    private ?User $user = null;

    /**
     * Obtiene el ID del producto
     * @return int|null
     */
    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * Obtiene el nombre del producto
     * @return string|null
     */
    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    /**
     * Establece el nombre del producto
     * @param string $nombre
     * @throws InvalidArgumentException if $nombre is null
     * @return $this
     */
    public function setNombre(string $nombre): self
    {
        $this->nombre = $nombre;
        return $this;
    }

    /**
     * Obtiene el precio del producto
     * @return float|null
     */
    public function getPrecio(): ?float
    {
        return $this->precio;
    }

    /**
     * Establece el precio del producto
     * @param float $precio
     * @return $this
     */
    public function setPrecio(float $precio): self
    {
        $this->precio = $precio;
        return $this;
    }

    /**
     * Obtiene la fecha de creación del producto
     * @return DateTimeInterface|null
     */
    public function getFechaCreacion(): ?DateTimeInterface
    {
        return $this->fechaCreacion;
    }

    /**
     * Establece la fecha de creación del producto
     * @param DateTimeInterface $fechaCreacion
     * @return $this
     */
    public function setFechaCreacion(DateTimeInterface $fechaCreacion): self
    {
        $this->fechaCreacion = $fechaCreacion;
        return $this;
    }

    /**
     * Obtiene el usuario del producto
     * @return User|null
     */
    public function getUser(): ?User
    {
        return $this->user;
    }

    /**
     * Establece el usuario del producto
     * @param User|null $user
     * @return $this
     */
    public function setUser(?User $user): self
    {
        $this->user = $user;
        return $this;
    }
}
