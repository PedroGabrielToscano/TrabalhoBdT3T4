package models;

public class MotivoFatura {
    private int idMotivo;
    private String motivo;

    public MotivoFatura() {
    }

    public MotivoFatura(int idMotivo, String motivo) {
        this.idMotivo = idMotivo;
        this.motivo = motivo;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "MotivoFatura{" +
                "idMotivo=" + idMotivo +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
